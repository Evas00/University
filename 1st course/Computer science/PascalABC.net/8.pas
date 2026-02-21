var 
  X: array [1..50] of integer;
  Y: array [1..60] of integer;
  s1, s2, i, j: integer;
  z: real;
begin
  for i:=1 to 50 do
    X[i] := Random(101)-50;
  println('Элементы массива X: ');
  for i:=1 to 50 do
    print(X[i]);
  println();
  for i:=1 to 50 do
    if X[i]>0 then
      s1:=s1+X[i];
  
  for j:=1 to 60 do
    Y[j] := Random(111)-50;
  println ('Элементы массива Y: ');
  for j:=1 to 60 do
    print(Y[j]);
  println();
  for j:=1 to 60 do
    if Y[j] < 0 then
      s2 := s2 + Y[j];
    
  z := (s1 + s2)/2;
  println('z =', z)
end.
