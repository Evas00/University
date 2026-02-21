function f(x:real):real;
begin
  result:=3*x-4*ln(x)-5;
end;
  begin
    var eps:=0.0005;
    var a,b,c:real;
    var n:integer;
    (a,b):=(2,4);
    c:=3;
    while (abs(f(c))>eps) do
    begin
      c:=(a+b)/2;
      n+=1;
      if f(c)*f(a)<0 then b:=c else a:=c;
    end;
    print(c,n);
  end.