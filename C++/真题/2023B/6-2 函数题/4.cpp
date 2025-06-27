#include <iostream>
#include <string>
#include <algorithm>
#include <numeric>
using namespace std;
/* 请在下方填写答案*/
/*class Worker;
class Reverser;
class Replacer;
*/
class Worker {
public:
	virtual void Process(std::string)=0;
};
class Reverser :public Worker {
	void Process(std::string str) override {
		std::string nstr="";
		reverse(str.begin(), str.end());
		cout << str << endl;
	};
};
class Replacer :public Worker {
	void Process(std::string str) override {
		std::string nstr = "";

		for (auto c : str)
		{
			if (c == ',') {
				c = ' ';
			}
			nstr.push_back(c);

		}
		cout << nstr << endl;

	};
};
int main()
{
	std::string str;
	std::cin >> str;
	Worker* rp1 = new Reverser;
	Worker* rp2 = new Replacer;
	rp1->Process(str);
	rp2->Process(str);
	return 0;
}