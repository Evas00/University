var
x,s,a,e: real; 
n,z: integer;
begin
x:=0.62; 
e:=0.0001;
n:=2;
a:=x;
while a>e do begin
 if odd(n) then z:=-1
 else z:=1;
 a:=z*(n/(sqr(n)-1))*sin(n*x);
 s:=s+a;
 n:=n+1;
 end;
 print(s);
end.