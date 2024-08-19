impl Solution {
    pub fn min_steps(n: i32) -> i32 {
        if n == 1 {
            return 0;
        }
        
        let mut steps = 0;
        let mut remaining = n;
        
        for i in 2..=n {
            while remaining % i == 0 {
                steps += i;
                remaining /= i;
            }
            if remaining == 1 {
                break;
            }
        }
        
        steps
    }
}