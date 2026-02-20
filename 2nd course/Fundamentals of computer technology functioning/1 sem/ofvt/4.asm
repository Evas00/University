data segment
    mass db 11010010b, 00010100b, 10011011b, 00111110b, 10000001b, 11010101b, 10011100b, 10000111b, 10000000b
    kol db 0
data ends
code segment
assume cs: code, ds: data
start:  
	mov ax, data 		; загрузка адреса
	mov ds, ax   		; загрузка сегмента данных
	lea si, mass 		; загрузка адреса смещения массива
	mov cx, 9    		; счетчик	

	tak_tak:         	; цикл чтобы пройтись по элементам массива
    	mov al, [si] 		; элемент массива загружаем в al
	and ah, 10000000b	; сравниваем первую цифру нынешнего числа 
	xor ah, bl		; и последнюю прошлого
	and ah, 1 		; смотрим произошел ли переход
	add kol, ah		
	mov bh, al		
	and bh, 1b		; в bh загружаем последнюю цифру этого числа 
	mov bl, bh		; и загружаем в bl
	shr al, 1 		; и сразу сдвигаем al вправо (так как bl уже явл последним)
    	push cx 		; заносим счетчик в стэк
    	mov cx, 7		

        tuk_tuk: 		
		mov ah, al 	; сохраняем текущий байт в ah
        	and ah, 1b      ; берем младший бит
    		xor ah, bl      ; XOR с предыдущим битом
    		and ah, 1b      ; смотрим произошел ли переход
        	add kol, ah
        	mov bl, al	; сохраняем текущий бит как предыдущий
        	shr al, 1 	; сдвигаем al вправо чтобы проверить следующие биты
        loop tuk_tuk
	
	mov bl, bh		; запоминаем в bl значение последней цифры этого числа
        pop cx
        inc si

    loop tak_tak

quit: 
	mov ax, 4c00h
	int 21h
code ends
end start