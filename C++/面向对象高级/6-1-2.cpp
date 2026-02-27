#include <iostream>
#include <string>
class People {
public:
    People(const std::string&);
    ~People(){}
    std::string getName();
    void setName(const std::string&);
private:
    std::string name;
};
class Student :public People {
public:
    Student(const std::string &, const std::string&);
    ~Student(){}
    std::string getName();
    void setName(const std::string&);
    std::string getCourse();
    void setCourse(const std::string&);
private:
    std::string course;
};
/* 请在下方填写答案*/
/*补全类成员函数*/

People::People(const std::string& n) : name(n) {}

std::string People::getName() {
    return name;
}

void People::setName(const std::string& n) {
    name = n;
}

Student::Student(const std::string& n, const std::string& c) : People(n), course(c) {}

std::string Student::getName() {
    return People::getName();
}

void Student::setName(const std::string& n) {
    People::setName(n);
}

std::string Student::getCourse() {
    return course;
}

void Student::setCourse(const std::string& c) {
    course = c;
}

int main()
{
        std::string name1, course1,name2, course2;
    std::cin >> name1 >> course1>> name2 >> course2 ;
    Student t(name1, course1);
    std::cout << t.getName() << std::endl;
    std::cout << t.getCourse() << std::endl;
        t.setName(name2);
        t.setCourse(course2);
        std::cout << t.getName() << std::endl;
    std::cout << t.getCourse() << std::endl;
    return 0;
}
