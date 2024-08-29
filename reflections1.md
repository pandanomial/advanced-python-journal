## 1. Python script can be executed in Terminal from the command line. And I observed in REP, I can type commands and instantly see the output printed out. 
### For example, I can see the value of any variable just by entering it into the prompt.
```
>>> name = "Steph"
>>> name
'Steph'
```
### Also, I can use type(), dir(), and help(), for example:
```
>>> name = "Steph"
>>> type(name)
<class 'str'>
```
## 2. Python NumPy is a great package for scientific computing.


### eg Create a NumPy array:
```
import numpy as np

arr = np.array([1, 2, 3, 4, 5])

print(arr)

print(type(arr))
```


##  3. Python uses easy and simple syntax 

### For example:  C++ code 
```
#include <iostream>
#include <string>
using namespace std;

int main() {
      string name;
      cin >> name;
      cout << "Good evening, " << name << endl;
      return 0;
}
```
### and Python code:
```
name = input()
print("Good evening, " + name)
```



