type
  predmets=(Matem,Fiz,Him,Istor,Bio);
  tstd=record
    Name:string[100];
    Group:String[20];
    predmet:array[predmets] of boolean;
    srbal:real;
  end;
const
  infilename='disciple.txt';
  maxstudents=100;
  prednames:array[predmets] of string=('Matem','Fiz','Him','Istor','Bio');
var
  count:word;
  choisecount:byte;
  f:text;
  std:array[1..maxstudents] of tstd;
  tempstd:tstd;
  p:integer;
  sign:boolean;
  s:string;
  choise:byte;
begin
  count:=1;
  choisecount:=0;
  writeln('Выберите одну из дисциплин:');
  for p:=1 to 5 do 
    println(p,' - ',prednames[predmets(p-1)]);
  readln(choise);
  assign(f,infilename);
  reset(f);
  while not eof(f) do
  begin
    readln(f,s);
    if s='' then inc(count);
    if pos('Fam',s)<>0 then std[count].name:=copy(s,pos(':',s)+2,255);
    if pos('Group',s)<>0 then std[count].Group:=copy(s,pos(':',s)+2,255);
    if pos('Srball',s)<>0 then val(copy(s,pos(':',s)+2,255),std[count].srBal,p);
    for p:=1 to 5 do if pos(prednames[predmets(p-1)],s)<>0 then
      std[count].predmet[predmets(p-1)]:=s[length(s)]='1';
  end;
  close(f);
  repeat
    sign:=false;
    for p:=1 to count-1 do if std[p].srbal<std[p+1].srbal then
    begin
      tempstd:=std[p];
      std[p]:=std[p+1];
      std[p+1]:=tempstd;
      sign:=true;
    end;
  until not sign;
  for p:=1 to count do
  begin
    if std[p].predmet[predmets(choise-1)] and (choisecount<8) then
      inc(choisecount);
      writeln('Фамилия студента: ',std[p].name);
      writeln('Индекс группы: ',std[p].group);
      writeln('Средний балл: ',std[p].srbal:0:2);
      writeln('--------------------');
    end;
end.