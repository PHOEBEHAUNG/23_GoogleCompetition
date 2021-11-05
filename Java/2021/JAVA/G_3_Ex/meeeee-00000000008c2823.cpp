// #include </Users/arpit/CP/stdc++.h>
#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define S second
#define F first
#define ull unsigned long long
ll mod=1e9+7;
#define PI 3.1415926535897932385
#define INF 100000000000000000ll
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);
#include <string>
string char_to_str(char c){string tem(1,c);return tem;}
 
typedef pair<long long, long long> ii;
ll max(ll a,ll b){if(a>b){return a;}return b;}
ll min(ll a,ll b){if(a<b){return a;}return b;}
#define MAXN 200005
// string to integer stoi() Remember: it takes string not character
// string to long long stoll()
// string.substr(position,length);
// integer to string to_string();
 
// To compile--> g++ -std=c++0x -o output one.cpp
// To run--> ./output
ll n,k;
ll b[505];

ll getl(ll left, ll l){
	ll sum2 = 0;
	ll sz2 = 1e10;
	unordered_map<ll, ll> pref;

	for (int i = 0; i < l; ++i)
	{
		sum2 = sum2 + b[i];
		if(pref.find(sum2-left) != pref.end()){
			sz2 = min(sz2, i-pref[sum2-left]);
		}
		pref[sum2] = i;
	}
	return sz2;
}

ll getr(ll left, ll r){
	ll sum2 = 0;
	ll sz2 = 1e10;
	unordered_map<ll, ll> pref;

	for (int i = r+1; i < n; ++i)
	{
		sum2 = sum2 + b[i];
		if(pref.find(sum2-left) != pref.end()){
			sz2 = min(sz2, i-pref[sum2-left]);
		}
		pref[sum2] = i;
	}
	return sz2;
}

ll fun(ll l, ll r){

	ll sum1 = 0;
	ll sz1 = r-l+1;
	for (int i = l; i<=r; ++i)
	{
		sum1 = sum1 + b[i];
	}

	if(sum1==k){
		return sz1;
	}

	if(sum1>k){
		return 1e10;
	}
	ll left = k-sum1;
	ll szl = getl(left, l);
	ll szr = getr(left, r);

	return min(sz1+szl, sz1+szr);
}

int main() 
{ 
	fastio;
// 	freopen("input.txt","r",stdin);
	// freopen("output.txt","w",stdout);

	ll t;
	cin>>t;

	for (int l = 1; l <= t; ++l)
	{
		cin>>n>>k;
		for (int i = 0; i < n; ++i)
		{
			cin>>b[i];
		}

		ll ans = 1e10;
		for (int l = 0; l < n; ++l)
		{
			for (int r = l; r < n; ++r)
			{
				ans = min(ans, fun(l, r));
			}
		}

		if(ans>n){
			cout<<"CASE #"<<l<<": "<<-1<<"\n";
		}
		else{
			cout<<"CASE #"<<l<<": "<<ans<<endl;			
		}

	}
    return 0;
}


















