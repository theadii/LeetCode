class Solution {
    public String reverseParentheses(String s) {

        Stack<Character> st = new Stack<>();
        

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c != ')') {
                st.push(c);
            } 
            else {

                Queue<Character> t = new LinkedList<>();
                while (st.peek() != '(') {
                    t.offer(st.pop());
                }

                st.pop();

               
                

                while (!t.isEmpty()) {
                    st.push(t.poll());
                }

                
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}