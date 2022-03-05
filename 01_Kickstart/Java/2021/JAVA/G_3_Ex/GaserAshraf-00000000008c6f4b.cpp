#include<bits/stdc++.h>
#include <unordered_map>
#include<unordered_set>

#include <bits/stdc++.h>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace __gnu_pbds;
using namespace std;

// Ordered Set Tree
typedef tree<pair<long long, int>, null_type, less<pair<long long, int>>, rb_tree_tag,
        tree_order_statistics_node_update>
        ordered_set;

using namespace std;
#define _USE_MATH_DEFINES
# define M_PI           3.14159265358979323846  /* pi */
#define ll long long
#define ld long double
#define vbe(v) ((v).begin()), ((v).end())
#define sz(v)     ((int)((v).size()))
#define prec(x)    << fixed<< setprecision(x)
#define clr(v, d)   memset(v, d, sizeof(v))
#define rep(i, v)   for(int i=0;i<sz(v);++i)
#define lp(i, n)    for(int i=0;i<(int)(n);++i)
#define lpi(i, j, n)  for(int i=(j);i<(int)(n);++i)
#define lpd(i, j, n)  for(int i=(j);i>=(int)(n);--i)
#define MIN(x, y) (((x) < (y)) ? (x) : (y))
#define FASTIO ios_base::sync_with_stdio(false); cin.tie(NULL); cin.tie(0);
#define INFLL 1e18
#define INF 1e9
#define MOD 1000000007
#define MOD1 998244353
#define MAXN 200001

ll GCD(ll a, ll b) { return (a) ? GCD(b % a, a) : b; }

ll LCM(ll a, ll b) { return a * b / GCD(a, b); }

ll fastpow(ll b, ll p) {
    if (!p) return 1;
    ll ret = fastpow(b, p >> 1);
    ret *= ret;
    if (p & 1) ret *= b;
    return ret;
}

int n, k;
int vec[5001];

struct segTree {
    int size;
    int len;
    vector<ll> vals;

    void init(int s) {
        size = 1;
        len=s;
        while (size < s) size *= 2;
        vals.resize(2 * size, INF);
    }

    void set(int i, ll v, int node, int lx, int rx) {
        if (rx - lx == 1) {
            vals[node] = v;
            return;
        }
        int m = (lx + rx) / 2;
        if (i < m)
            set(i, v, 2 * node + 1, lx, m);
        else
            set(i, v, 2 * node + 2, m, rx);
        vals[node] = min(vals[2 * node + 1], vals[2 * node + 2]);
    }

    void set(int i, ll v) {
        set(i, v, 0, 0, size);
    }

    ll sum(int l, int r, int node, int lx, int rx) {
        if (lx >= r || l >= rx)return INF;
        if (lx >= l && rx <= r)return vals[node];
        int m = (lx + rx) / 2;
        return min(sum(l, r, 2 * node + 1, lx, m), sum(l, r, 2 * node + 2, m, rx));
    }

    ll sum(int l, int r) {
        return sum(l, r, 0, 0, size);
    }
};

void solve(int tst) {
    cout << "Case #" << tst << ": ";
    cin >> n >> k;
    lp(i, n) {
        cin >> vec[i];
        // st.set(i, vec[i]);
    }

    map<pair<int, int>, int> suff;
    unordered_map<int, ordered_set> maIdxSum;
    unordered_map<int, segTree> maSeg;
    lpd(i, n - 1, 0) {
        int sum = 0;
        lpd(j, i, 0) {
            sum += vec[j];
            int len = i - j + 1;
            if (suff.find({j, sum}) == suff.end()) {
                suff[{j, sum}] = len;
                maIdxSum[sum].insert({j, len});
            } else {
                if (len < suff[{j, sum}]) {
                    maIdxSum[sum].erase({j, suff[{j, sum}]});
                    suff[{j, sum}] = len;
                    maIdxSum[sum].insert({j, len});
                }
            }
        }
    }

    for (auto i:maIdxSum) {
        int size = i.second.size();
        maSeg[i.first].init(size);
        int idx = 0;
        for (auto z:i.second)maSeg[i.first].set(idx++, z.second);
    }

    int ans = INF;
    lp(start, n) {
        int s1 = vec[start];
        lpi(end, start + 1, n + 1) {
            if (end != start + 1)s1 += vec[end - 1];
            int len = end - start;
            if (s1 == k) {
                ans = min(ans, len);
                continue;
            }
            if (s1 > k)continue;
            int need = k - s1;

            if (maIdxSum.find(need) == maIdxSum.end())continue;
            auto start = maIdxSum[need].lower_bound({end, 0});
            if (start == maIdxSum[need].end())continue;

            pair<int, int> tt = *start;

            int idx = maIdxSum[need].order_of_key({tt.first, tt.second});
            int sz = maSeg[need].len;
            int mn = maSeg[need].sum(idx, sz);
            ans = min(ans, mn + len);

        }
    }

    if (ans == INF)cout << -1;
    else cout << ans;
}

int main() {
    FASTIO;
    //freopen("gaser.in", "r", stdin);
    int t = 1;
    cin >> t;
    lp(i, t) {
        solve(i + 1);
        cout << "\n";
    }
}