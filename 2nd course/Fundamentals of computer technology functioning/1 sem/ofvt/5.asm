data segment
    IN_STR db 80, ?, 82 dup(?)  ;максимальная длина строки, фактическая длина, выделяется под фактически введенные символы.
data ends
code segment
    assume cs: code, ds: data
    start:
        mov ax, data
        mov ds, ax
        mov ah, 0Ah		; устанавливаем номер функции DOS для считывания строки
        lea dx, IN_STR		; загружаем адрес массива IN_STR в регистр DX.
        int 21h			; вызываем прерывание, которое обрабатывает ввод строки по спецификации функции 0Ah, сохраняя данные в IN_STR.
        lea si, IN_STR + 2	; устанавливаем указатель SI на первый символ введенной строки 
        mov cl, IN_STR + 1	; загружаем в регистр CL фактическую длину введенной строки.
	xor bp, bp
        mov ah, 02h		; Устанавливает функцию вывода символов в AH 
        mov dl, 0Ah		; и символ новой строки (0Ah) в DL, затем выводит его на экран.
        int 21h
    symbols:
        mov ah, 02h
        mov dl, [si]		; извлекаем текущий символ из строки.
        cmp dl, 020h		; сравниваем 1 символ с пробелом.
	je da_eto_tak		
	cmp dl, 09h		; сравниваем 1 символ с символом табуляции.
	je da_eto_tak
        jmp vse_ok		; если не пробел и табуляция
    da_eto_tak:
        inc si			 
        mov bl, [si]		; извлекаем следующий символ в BL.
        dec si
        cmp bl, 020h		; сравниваем 2 символ с пробелом.
        je step	
	cmp bl, 09h		; сравниваем 2 символ с символом табуляции.
	je step
        mov dl, 0Ah		; если 2 символ не пробел или табуляция  
	int 21h			; тогда переходим на новую строку и фиксируем сдвиг
	inc bp
	mov dl, ' '
	push cx
	mov cx, bp
	boje:
		int 21h
	loop boje
	pop cx
	inc si
        loop symbols
    vse_ok:
        int 21h
    step:
        inc si
        loop symbols
    quit:
        mov ax, 4C00h
        int 21h
code ends
end start