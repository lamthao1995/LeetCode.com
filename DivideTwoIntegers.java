typedef long long ll;
int divide(int n_, int d_) {
    ll ans=0;
    ll n=abs((ll)n_);
    ll d=abs((ll)d_);
    while(n>=d){
        ll a=d;
        ll m=1;
        while((a<<1) < n){a<<=1;m<<=1;}
        ans+=m;
        n-=a;
    }
    if((n_<0&&d_>=0)||(n_>=0&&d_<0))
        return -ans;
    return ans;
}