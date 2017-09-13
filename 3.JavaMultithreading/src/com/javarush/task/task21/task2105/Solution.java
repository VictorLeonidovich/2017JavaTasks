package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
       if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Solution))
            return false;
        if (this.first == null && ((Solution) o).first != null || this.first != null && ((Solution) o).first == null) {return false;}
        if (this.last == null && ((Solution) o).last != null || this.last != null && ((Solution) o).last == null) {return false;}
        if (this.first != null) if (this.first.equals(((Solution) o).first)) return true;
        if (this.last != null) if (this.last.equals(((Solution) o).last)) return true;

        //if (this.first != null){if (!this.first.equals(((Solution) o).first) || ((Solution) o).first == null) return false;}
        //if (this.last != null){if (!this.last.equals(((Solution) o).last) || ((Solution) o).last == null) return false;}
                //(this.first == null && ((Solution) o).first == null || this.last == null && ((Solution) o).last == null)return true;
        //if ((this.first.equals(((Solution) o).first)) && this.last.equals(((Solution) o).last)) return true;
        //Solution n = (Solution) o;
        //n.first.equals(this.first) && n.last.equals(this.last)
        return true;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solution solution = (Solution) o;

        if (!first.equals(solution.first)) return false;
        return last.equals(solution.last);

    }*/

    @Override
    public int hashCode() {
        int result;
        if (first == null){result = 0;}else {result = first.hashCode();}
        if (last == null){result = 31 * result + 0;}else{
        result = 31 * result + last.hashCode();}
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, null)));
    }
}
