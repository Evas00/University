var
  i, k: integer;
  s: string;
begin
  println('Введите текст');
  readln(s);
  i:=1;
  while i<=length(s) do
  begin
    if (s[i] = ',') then
    begin
      delete(s, i, 1);
      inc(k);
    end;
    inc(i);
  end;
  println('колличество "," в тексте= ', k);
  println('Преобразованная строка: ', s);
end.