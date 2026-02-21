var
  X,Y: array[1..40] of integer;
  i,j: integer;
begin
  for i:=1 to 40 do
  begin
    X[i]:=random(200) - 100; 
    if X[i]>0 then begin
      inc(j);
      Y[j]:=X[i];
      end;
  end;
  println('Исходный массив: ');
  X.println();
  println('Отсортированный массив: ');
  for i:=1 to j do write(Y[i], ' ');
end.