/*
Based on: https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/discuss/5715993/JavaC%2B%2BPython-Sorting-nlog(n)-Solution-with-Proof


ChatGPT Generated intution to help understand better in simple word


        The damage Bob takes depends on how long each enemy is alive.

        Damage per Second: Each enemy deals a certain amount of damage every second (damage[i]).
        Time to Kill: The time Bob needs to kill an enemy depends on its health and Bob's attack power. If Bob's power is power, the time to kill an enemy with health[i] is time[i] = (health[i] + power - 1) / power.
        Two Scenarios for Minimizing Damage
        Let's say Bob has two enemies:

        Enemy i deals damage[i] damage per second and takes time[i] seconds to kill.
        Enemy j deals damage[j] damage per second and takes time[j] seconds to kill.
        If Bob decides to kill enemy i first and then enemy j, the total damage he takes is:

        First: time[i] * damage[i] (damage from enemy i while it's alive).
        Second: (time[i] + time[j]) * damage[j] (damage from enemy j while it's alive and after enemy i is dead).
        If Bob decides to kill enemy j first and then enemy i, the total damage he takes is:

        First: time[j] * damage[j] (damage from enemy j while it's alive).
        Second: (time[j] + time[i]) * damage[i] (damage from enemy i while it's alive and after enemy j is dead).
        Key Idea: To minimize the damage Bob takes, we need to decide the order of killing the enemies based on minimizing the total damage.


        Comparing Two Enemies
        Let's say Bob has two enemies: Enemy i and Enemy j.

        Enemy i deals damage[i] damage per second and takes time[i] seconds to kill.
        Enemy j deals damage[j] damage per second and takes time[j] seconds to kill.
        To decide whether to kill Enemy i first or Enemy j first, we compare:

        Kill Enemy i first, then Enemy j:

        Total extra damage = time[i] * damage[j] (this is the extra damage Bob will take from Enemy j while he's still killing Enemy i)
        Kill Enemy j first, then Enemy i:

        Total extra damage = time[j] * damage[i] (this is the extra damage Bob will take from Enemy i while he's still killing Enemy j)
        How to Decide the Order
        Compare time[i] * damage[j] with time[j] * damage[i]:
        If time[i] * damage[j] < time[j] * damage[i], it means Bob will take less total damage if he kills Enemy i before Enemy j.
        If time[i] * damage[j] > time[j] * damage[i], it means Bob will take less total damage if he kills Enemy j before Enemy i.

*/

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        
        long[] time = new long[n];
        for(int i = 0; i < n; i++) {
            time[i] = (long) ((health[i] + (power - 1)) / power);
        }
        
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            indexes.add(i);
        }
        
        indexes.sort((i, j) -> {
            long a = time[i] * damage[j];
            long b = time[j] * damage[i];
            return Long.compare(a, b);
        });
        
        long res = 0;
        long currTime = 0;
        
        for(int i : indexes) {
            currTime += time[i];
            res += damage[i] * currTime;
        }
        
        return res;
    }
}