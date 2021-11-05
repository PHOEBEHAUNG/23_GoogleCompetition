#include <bits/stdc++.h>
using namespace std;
int bs(vector<int>&v,int val){
	int l=0,r=v.size()-1,m,ans=-1;
	while(l<=r){
		m=(l+r)/2;
		if(v[m]>val){
			ans=m;
			l=m+1;
		}
		else{
			r=m-1;
		}
	}
	return ans;
}
int main() {
	// your code goes here
	int t;
	cin>>t;
	for(int p=1;p<=t;p++){
		int n,k;
		cin>>n>>k;
		int arr[n];
		for(int i=0;i<n;i++){
			cin>>arr[i];
		}
		int ans=-1;
		if(k==0)
		ans=0;
		else{
			vector<int>vi[k+1];
			vector<int>vc[k+1];
			int vs[k+1];
			memset(vs,0,sizeof(vs));
			for(int i=n-1;i>=0;i--){
			int sum=0,s=0;
			for(int j=i;j<n;j++){
				sum+=arr[j];
				s++;
				if(sum<=k){
					vi[sum].push_back(i);
					if(vs[sum]==0){
						vc[sum].push_back(s);
					}
					else{
						int temp = vc[sum][vs[sum]-1];
						if(s<=temp)
						vc[sum].push_back(s);
						else
						vc[sum].push_back(temp);
					}
					vs[sum]++;
				}
				else{
					break;
				}
			}
			}
			
		for(int i=0;i<n;i++){
			int sum=0,s=0;
			for(int j=i;j<n;j++){
				sum+=arr[j];
				s++;
				if(sum<=k){
					if(sum == k){
						if(ans<0 || ans>s){
							ans=s;
						}
					}
					else{
						int temp = bs(vi[k-sum],j);
						if(temp>=0){
							if(ans<0 || ans>s+vc[k-sum][temp]){
								ans=s+vc[k-sum][temp];
							}
						}
					}
				}
				else{
					break;
				}
			}
		}
		}
		cout<<"Case #"<<p<<": "<<ans<<endl;
	}
	return 0;
}