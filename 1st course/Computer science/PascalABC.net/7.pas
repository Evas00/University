var a:array[1..50,1..50] of integer;
    k,n,i,j,imax,jmax,imin,jmin,max,min,x:integer;
begin
randomize;
print('K=');
readln(k);
print('N=');
readln(n);
if (k<=20) and (n<=10) then
  begin
    println('Исходная матрица:');
    for i:=1 to k do
    begin
        for j:=1 to n do
        begin
            a[i,j]:=random(40);
            print(a[i,j]);
        end;
        println();
    end;
    max:=a[1,1];
    min:=a[1,1];
    imax:=1;
    imin:=1;
    jmax:=1;
    jmin:=1;
    for i:=1 to k do
      for j:=1 to n do
        if a[i,j]>max then
          begin
            max:=a[i,j];
            imax:=i;
            jmax:=j;
          end
        else if a[i,j]<min then
          begin
            min:=a[i,j];
            imin:=i;
            jmin:=j;
          end;
    println('Максимальный элемент-a[',imax,',',jmax,']=',max);
    println('Минимальный элемент-a[',imin,',',jmin,']=',min);
    x:=a[imax,jmax];
    a[imax,jmax]:=a[imin,jmin];
    a[imin,jmin]:=x;
    println('Конечная матрица:');
    for i:=1 to k do
      begin
        for j:=1 to n do
          print(a[i,j]);
        println;
      end;
  end
  else
    println('Размеры матрицы некорректны')
end.