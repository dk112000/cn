#include<iostream>
using namespace std;
int main(){
int i,j,k,l;
//Get frame
int fs;
cout<<"Enter the size of data: "<<endl; cin>>fs;
int f[20]; cout<<"Enter data: ";
for(i=0;i<fs;i++) { cin>>f[i]; }
//get generator
int gs;
cout<<"Enter key size: "<<endl; cin>>gs;
int g[20];cout<<"Enter key: ";
for(i=0;i<gs;i++) { cin>>g[i]; }

cout<<endl<<"Sender Side: "<<endl;
cout<<"Dataword(dividend): "<<endl;

for(i=0;i<fs;i++) { cout<<f[i]; }
cout<<"\nGenerator(divisor): ";
for(i=0;i<gs;i++) { cout<<g[i]; }

//Append 0's
int rs=gs-1;
cout<<"Number of 0's to be appended: "<<rs<<endl;
for(i=fs;i<fs+rs;i++){ f[i]=0; }

int temp[20];
for(i=0;i<20;i++){ temp[i]=f[i]; }
cout<<"Message after appeneding 0's: "<<endl;
for(i=0;i<fs+rs;i++){ cout<<temp[i]; }

//Division
for(i=0;i<fs;i++){ 
  j=0; k=i;
//chech whether it is divisible or not
if(temp[k]>=g[j]) {
for(j=0,k=i;j<gs;j++,k++) {
if((temp[k]==1 && g[j]==1) || (temp[k]==0 && g[j]==0)){ temp[k]=0; }
else{ temp[k]=1; } } } }

//CRC
int crc[15];
for(i=0,j=fs;i<rs;i++,j++){
crc[i]=temp[j]; }
cout<<endl;
cout<<"CRC bits(Remainder/Syndrome): "<<endl;
for(i=0;i<rs;i++){
cout<<crc[i]; }


cout<<"Transmitted frame: "<<endl;
int tf[15];
for(i=0;i<fs;i++){ tf[i]=f[i]; }
for(i=fs,j=0;i<fs+rs;i++,j++){ tf[i]=crc[j]; }

for(i=0;i<fs+rs;i++){ cout<<tf[i]; }

cout<<"Receiver side"<<endl; cout<<"Receiver frame"<<endl;
for(i=0;i<fs+rs;i++){cout<<tf[i]; }

for(i=0;i<fs+rs;i++){ temp[i]=tf[i]; }

//Division
for(i=0;i<fs+rs;i++){
   j=0; k=i;
if(temp[k]>=g[j]) {
for(j=0,k=i;j<gs;j++,k++){
if((temp[k]==1 && g[j]==1) || (temp[k]==0 && g[j]==0)){
temp[k]=0; } else{ temp[k]=1; } }} }

cout<<"Remainder (syndrome): "<<endl;
int rrem[15];
for(i=fs,j=0;i<fs+rs;i++,j++){ rrem[j]=temp[i]; }

for(i=0;i<rs;i++){ cout<<rrem[i]; }

int flag=0;
for(i=0;i<rs;i++){ if(rrem[i]!=0){ flag=1; } }
if(flag==0){
cout<<"Since remainder is 0 hence message transmitted is correct"<<endl; } else{
cout<<"Since remainder is not 0 hece message contains Error"<<endl; }return 0;}