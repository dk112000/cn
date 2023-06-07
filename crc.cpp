#include <iostream>
#include <vector>
using namespace std;

vector<bool> crc(vector<bool> msg, vector<bool> gen, int msg_size,
                 int gen_size) {
  for (int i = 0; i < msg_size; i++) {
    if (msg[i] == 0) {
      continue;
    } else {
      for (int j = 0; j < gen_size; j++)
        msg[i + j] = msg[i + j] ^ gen[j];
    }
  }
  vector<bool> rem;
  cout << "\nCRC remainder: ";
  for (int i = msg_size; i < (msg_size + gen_size - 1); i++) {
    rem.push_back(msg[i]);
    cout << msg[i];
  }
  return rem;
}

int main() {
  int msg_size;
  cout << "Enter size of message: ";
  cin >> msg_size;
  vector<bool> msg;
  cout << "Enter message: ";
  for (int i = 0; i < msg_size; i++) {
    bool value;
    cin >> value;
    msg.push_back(value);
  }

  int gen_size;
  cout << "\nEnter CRC generator size: ";
  cin >> gen_size;
  vector<bool> gen;
  cout << "Enter Generator: ";
  for (int i = 0; i < gen_size; i++) {
    bool value;
    cin >> value;
    gen.push_back(value);
  }

  cout << "\nMessage: ";
  for (int i = 0; i < msg_size; i++)
    cout << msg[i];

  cout << "\nGenerator: ";
  for (int i = 0; i < gen_size; i++)
    cout << gen[i];

  vector<bool> msgz(msg);
  msgz.resize(msg_size + gen_size - 1, 0);

  cout << "\nMessage After appending 0's: ";
  for (int i = 0; i < (msg_size + gen_size - 1); i++)
    cout << msgz[i];

  vector<bool> rem = crc(msgz, gen, msg_size, gen_size);

  vector<bool> rmsg;
  cout << "\n\nEnter recieved message: ";
  for (int i = 0; i < msg_size; i++) {
    bool value;
    cin >> value;
    rmsg.push_back(value);
  }

  rmsg.insert(rmsg.end(), rem.begin(), rem.end());
  vector<bool> rrem = crc(rmsg, gen, msg_size, gen_size);
  
  bool error = 0;
  for (auto it : rrem) {
    if (it == 1) {
      cout << "\nerror detected";
      error = 1;
      break;
    }
  }
  if (error == 0) {
    cout << "\nerror not detected";
  }

  return 0;
}
