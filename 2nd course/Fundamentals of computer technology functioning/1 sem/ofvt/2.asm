data segment ;директива начала сегмента данных
  a dw 100
  b dw 30
  c dw 44
  x dd ?
data ends ;директива конца сегмента данных
code segment ;директива начала сегмента кодов
assume cs: code, ds: data ;имена сегментов кодов и данных
start:  
    mov ax, data; заношу данные в регистр ax(загрузка адреса)
    mov ds, ax; переношу данные в регистр ds(загрузка сегмента данных)
    mov ax, b; заношу в регистр ax значение a
    mov bx, a
    sal ax, 1 ;умножение через 1 арифм. сдвиг b*2
    jns tutu
    neg ax
    add ax, bx ;a-2b
    jns tutu
    mov cx, c
    sar cx, 1 ;деление через 1 арифм. сдвиг c/2
    sar cx, 1 ;c/4
    add ax, cx ;a-2b+c/4
    jns tutu
    mov bx, ax
    sal ax, 1
    jns tutu
    add ax, bx
    jns tutu
    sal ax, 1 ;6(a-2b+c/4)
    jns tutu
    mov bx, 10
    add ax, bx ;6(a-2b+c/4)+10
    jns tutu
    mov word ptr x, ax; переношу ответ в x
    mov word ptr [x+2], dx; также если возникнет переполнение переношу в старшие байты x
    tutu: adc dx, 0
  quit: 
    mov ax, 4c00h; конец программы
    int 21h
code ends ;директива конца сегмента кодов
end start
	

