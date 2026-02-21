function Fi(x: real):real; 
     Fi:=exp(3*ln((ln(x)/x)));
 
function F1(x: real):real;
  begin
     F1:=((-2*exp(3*ln(ln(x)))-3*sqr(ln(x))-3*ln(x))/(4*sqr(x)))-3/(8*sqr(x)); 
  end;
 
procedure Res(a,b,n:integer);
   var
    dx,Step,Result,TResult: real;
  begin
    dx:=(b-a)/N;
    Step:=a+dx;
    Result:=(Fi(a)+Fi(b))/2;
    While Step<b do
          begin
               Result:=Result+Fi(Step);
               Step:=Step+dx;
          end;
    Result:=Result*dx;
    TResult:=F1(b)-F1(a);
    println('Количество интервалов:', N);
    println('Приближенное значение функции:', Result);
    println('Точное значение функции на данном интервале:', TResult);  
  end;
  
var
  a,b,N: integer;
begin
  a:=1;
  b:=2;
  N:=50;
  Res(a,b,N);
end.