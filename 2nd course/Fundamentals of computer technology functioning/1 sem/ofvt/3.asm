data segment
mass dw 20,-11,10,14,-6,8,17,-40,33,-1
pr dd ?
data ends
code segment
assume cs: code, ds: data
start:  
	mov ax, data ;загрузка адреса
	mov ds, ax ;загрузка сегмента данных
	lea bx, mass ;загрузка адреса смещения массива
	mov cx, 10 ;счетчик	
	mov ax, 1
pup:
	cmp word ptr [bx], 0 ;Сравнение элемента с 0
	js minus
	mul word ptr [bx]
	mov word ptr pr, ax
	cmp word ptr pr+2, 0
	jz ne_nolik
	mov ax, word ptr pr+2
	mov word ptr pr+2,dx
	mul word ptr [bx]
	mov dx, ax
ne_nolik:
	add word ptr pr+2, dx
minus:
	inc bx ;следующий элемент
	inc bx ;массива
	loop pup
quit: 
	mov ax, 4c00h
	int 21h
code ends
end start