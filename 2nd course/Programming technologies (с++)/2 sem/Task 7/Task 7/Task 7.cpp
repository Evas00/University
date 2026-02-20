#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <locale>
#include <string>
using namespace std;

#define Step_min 80

class Statement
{
protected:
    const char* STATE = "Statement.bin";
    int IdSt;
    int St;
    char FIO[64];
    int NomPr;  
    char NamePr[64];
    int Ball;

public:
    Statement() //конструктор
    {
        IdSt = 0;
        St = 0;
        FIO[0] = ' ';
        NomPr = 0;
        NamePr[0] = ' ';
        Ball = 0;
    }

    void In();
    void Out();
    void Upd(int St, int NomPr);
    float SrBallPr(int NomPr);
    float SrBallSt(int St);
    void PrInfo(int NomPr);
};

class Grade : protected Statement
{
public:
    void ExamsSt(int IdSt);
    void StList();
    void PrList();
    void SrPrList();
    void SrStList();
    void Stipendia();
};

void Statement::In() //1
{
    FILE* File = fopen(STATE, "ab+");

    cin >> IdSt;
    cin >> St;
    cin >> FIO;
    cin >> NomPr;
    cin >> NamePr;
    cin >> Ball;

    fwrite(this, sizeof(*this), 1, File);
    fclose(File);
}

void Statement::Out() //2
{
    FILE* File = fopen(STATE, "rb");
    Statement State;

    printf("Студ. билет\tФИО студента\tID предмета\tНаименование предмета\n");

    while (true)
    {
        fread(&State, sizeof(State), 1, File);

        if (feof(File)) break;
        
        cout << State.St << "\t";
        cout << State.FIO << "\t\t";
        cout << State.NomPr << "\t\t";
        cout << State.NamePr << "\t\t\t";
        cout << State.Ball << "\n";
    }
    fclose(File);
}

void Statement::Upd(int St, int NomPr) //3
{
    FILE* File = fopen(STATE, "rb");
    Statement State;
    int pos = 0;

    while (true)
    {
        fread(&State, sizeof(State), 1, File);
        pos++;

        if (feof(File))
        {
            printf("Такой записи нет, обновление невозможно\n");
            break;
        }

        if ((State.St == St) and (State.NomPr == NomPr))
        {
            fclose(File);

            File = fopen("Statement.dat", "r+");
            fseek(File, (pos - 1) * sizeof(State), SEEK_SET);
;
            cin >> State.St;
            cin >> State.FIO;
            cin >> State.NomPr;
            cin >> State.NamePr;
            cin >> State.Ball;
            break;
        }
    }
    fclose(File);
}

float Statement::SrBallPr(int NomPr) //4
{
    FILE* File = fopen(STATE, "rb");
    Statement State;

    int sum = 0;
    int k = 0;

    while (true)
    {
        fread(&State, sizeof(State), 1, File);

        if (feof(File)) break;

        if (State.NomPr == NomPr)
        {
            sum += State.Ball;
            k++;
        }
    }
    fclose(File);

    return (sum/k*1.0);
}

float Statement::SrBallSt(int St) //5
{
    FILE* File = fopen(STATE, "rb");
    Statement State;

    int sum = 0;
    int k = 0;

    while (true)
    {
        fread(&State, sizeof(State), 1, File);

        if (feof(File)) break;

        if (State.St == St)
        {
            sum += State.Ball;
            k++;
        }
    }
    fclose(File);

    return (sum/k*1.0);
}

void Statement::PrInfo(int NomPr) //6
{
    FILE* File = fopen(STATE, "rb");
    Statement State;
    bool Item = true;

    while (true)
    {
        fread(&State, sizeof(State), 1, File);

        if (feof(File)) break;

        if ((State.NomPr == NomPr) and Item)
        {
            cout << "Информация по предмету: " << State.NomPr << endl << endl;
            printf("№ \tФИО студента\t\tУспеваемость\n");
            cout << State.St << "\t";
            cout << State.FIO << "\t\t";
            cout << State.Ball << endl;

            Item = false;
        }
        else if (State.NomPr == NomPr)
        {
            cout << State.St << "\t";
            cout << State.FIO << "\t\t";
            cout << State.Ball << endl;
        }
    }
    fclose(File);
}

void Grade::ExamsSt(int Id) //7
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    bool list = true;

    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;

        if (grade.IdSt == Id and list)
        {
            cout << "Список сданных экзаменов студента " << grade.FIO << endl;

            cout << "ID предмета\tНазвание предмета\tУспеваемость\n";
            cout << grade.NomPr << "\t\t";
            cout << grade.NamePr << "\t\t\t";
            cout << grade.Ball << endl;

            list = false;
        }
        else if (grade.IdSt == Id)
        {
            cout << grade.NomPr << "\t\t";
            cout << grade.NamePr << "\t\t\t";
            cout << grade.Ball << endl;
        }
    }
    fclose(File);
}

void Grade::StList() //8
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    cout << "ID студента\tФИО студента\n";
    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;

        cout << grade.IdSt << "\t\t";
        cout << grade.FIO << endl;
    }
    fclose(File);
}

void Grade::PrList() //9
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    cout << "ID предмета\tНазвание предмета\n";
    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;

        cout << grade.NomPr << "\t\t";
        cout << grade.NamePr << endl;
    }
    fclose(File);
}

void Grade::SrPrList() //10
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    cout << "ID предмета\tНазвание предмета\tСредний балл успеваемости\n";
    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;

        cout << grade.NomPr << "\t\t";
        cout << grade.NamePr << "\t\t";
        cout << grade.SrBallPr(grade.NomPr) << endl;
    }
    fclose(File);
}

void Grade::SrStList() //11
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    cout << "ID студента\tФИО студента\tСредний балл успеваемости\n";
    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;

        cout << grade.IdSt << "\t\t";
        cout << grade.FIO << "\t\t";
        cout << grade.SrBallSt(grade.IdSt) << endl;
    }
    fclose(File);
}

void Grade::Stipendia() //12
{
    FILE* File = fopen(STATE, "rb");
    Grade grade;
    cout << "ID студента\tФИО студента\n";
    while (true)
    {
        fread(&grade, sizeof(grade), 1, File);

        if (feof(File)) break;
        if (grade.Ball>= Step_min) {
            cout << grade.IdSt << "\t\t";
            cout << grade.FIO << endl;
        }
    }
    fclose(File);
}

int main()
{
    setlocale(LC_ALL, "RUS");
    cout << "Саргсян 19.03.25" << endl;
    Statement statement;
    Grade grade;
    int St, NomPr, IdSt;
    int n = 1;
    while (n != 0) {
        cin >> n;
        switch (n) {
            case 0:
                break;
            case 1:
                statement.In(); break;
            case 2:
                statement.Out(); break;
            case 3: {
                cin >> St >> NomPr;
                statement.Upd(St, NomPr);
                break;
            }
            case 4: {
                cin >> NomPr;
                statement.SrBallPr(NomPr);
                break;
            }
            case 5: {
                cin >> St;
                statement.SrBallSt(St);
                break;
            }
            case 6: {
                cin >> NomPr;
                statement.PrInfo(NomPr);
                break;
            }
            case 7: {
                cin >> IdSt;
                grade.ExamsSt(IdSt);
                break;
            }
            case 8:
                grade.StList(); break;
            case 9:
                grade.PrList(); break;
            case 10:
                grade.SrPrList(); break;
            case 11:
                grade.SrStList(); break;
            case 12:
                grade.Stipendia(); break;
        }
    }
}