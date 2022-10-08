/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
        return dfs(map,id);
    }
    private int dfs(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        int ans = e.importance;
        for(int sub : e.subordinates){
            ans += dfs(map,sub);
            
        }
        return ans;
    }
}