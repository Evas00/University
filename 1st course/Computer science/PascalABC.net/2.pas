var
  a:=0.9;
  x:=0.8;
  y:real;
  begin
    while x<2.1 do
    begin
      if x<=1 then
        y:=2*a*cos(x)+3*x*x
      else
        y:=a*(ln(x)/ln(10))+exp(1/3*ln(abs(x)));
      println('при x=',x, '  ', y);
      x:=x+0.1;
    end;
  end.