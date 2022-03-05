#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define ff first
#define ss second
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int N = 100005;
const ll MOD = 1000000007;
const ll INF = 0x3f3f3f3f3f3f3f3f;

ll b[5005], k;

vector<pair<int, int> > s[1000005];

void go(){
    int n;
    cin>>n>>k;

    for(int i = 1; i <= n; ++i){
        cin>>b[i];
        b[i] += b[i - 1];
    }
    int ans = N;
    
    for(int j = 0; j <= n; ++j){
        for(int i = j; i >= 0; --i){
            if(b[j] - b[i] > k)
                break;
            if(s[b[j] - b[i]].empty() || s[b[j] - b[i]].back().ss > j - i)
                s[b[j] - b[i]].push_back({j, j - i});
        }
    }

    for(int i = 0; i <= n; ++i){
        for(int j = i; j <= n; ++j){
            if(b[j] - b[i] > k)
                break;
            int le = k - (b[j] - b[i]);
            int it = lower_bound(s[le].begin(), s[le].end(), make_pair(i + 1, -1)) - s[le].begin();
            if(it == 0)
                continue;
            --it;
            ans = min(ans, j - i + s[le][it].ss);
        }
    }

    if(n * (n - 1) / 2 >= k){
        for(int i = 0; i <= k; ++i)
            s[i].clear();
    } else {
        for(int i = 0; i <= n; ++i){
            for(int j = i; j <= n; ++j){
                if(b[j] - b[i] <= k)
                    s[b[j] - b[i]].clear();
                else 
                    break;
            }
        }
    }
    if(ans == N) ans = -1;
    cout<<ans<<'\n';
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    
    int tt;
    cin>>tt;
    for(int i = 1; i <= tt; ++i){
        cout<<"Case #"<<i<<": ";
        go();
    }
}