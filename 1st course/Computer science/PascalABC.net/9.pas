 type  M1=array [1..10,1..10] of integer;
 type  M2=array [1..15,1..15] of integer;
procedure FullM1(var a: M1; m,n: integer);
  begin
    for var i:=1 to M do 
      for var j:=1 to N do
        a[i,j]:=Random(30);
  end;

procedure FullM2(var b: M2; k,s: integer);
  begin
    for var i:=1 to K do 
    for var g:=1 to S do 
      b[i,g] := Random(30);
  end;
 
procedure PrM1(const a: M1; m,n: integer); 
  begin
    for var i:=1 to M do 
    begin
      for var j:=1 to N do 
        print(a[i,j]);
      println;  
    end;
  end;

procedure PrM2(const b: M2; k,s: integer);
  begin
    for var i:=1 to K do 
    begin
      for var g:=1 to S do 
        print(b[i,g]);
      println;  
    end;
  end;

var
  sum,sum2,i,g, S1,z, x, S2: integer;
  a: M1;
  b: M2;
begin
  FullM1(a,10,10);
  
  println('Матрица A:');
  PrM1(a,10,10);
  
  for i:=2 to 10 do
    for g:=10-i+2 to 10 do
      a[i,g] := 0;
  for i:=1 to 10 do
    for g:=1 to 10 do
      S1:=S1 + a[i,g];
  
  println('Преобразованная матрица A:');
  PrM1(a,10,10);
  println('Сумма элементов матрицы A:', S1);
  
  FullM2(b,15,15);
 
  println('Матрица B:');
  PrM2(b,15,15);
 
  for i:=2 to 15 do
    for g:=15-i+2 to 15 do
      b[i,g]:=0;
  for i:=1 to 15 do
    for g:=1 to 15 do
      S2:=S2 + b[i,g];
 
  println('Преобразованная матрица B:');
  PrM2(b,15,15);
  println('Сумма элементов матрицы B:', S2)
end.
