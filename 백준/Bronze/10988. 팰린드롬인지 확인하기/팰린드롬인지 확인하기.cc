#include <iostream>
#include <string>

using namespace std;

int main() {
	string input;
	cin >> input;

	int length = (int) input.length();
	for(int i = 0; i < length / 2; i++) {
		if(input[i] != input[length - i - 1]) {
			cout << "0";
			return 0;
		}
	}
	cout << "1";
}
