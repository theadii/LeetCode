class Solution {
    int n;
    String s;
    int idx = 0;

    Set<String> getUnit() {
        Set<String> res = new HashSet<>();

        if (s.charAt(idx) == '{') {
            idx++;
            res = performUnion();
            idx++; // skip '}'
        } else {
            res.add(String.valueOf(s.charAt(idx)));
            idx++;
        }

        return res;
    }

    Set<String> concat() {
        Set<String> res = new HashSet<>();
        res.add("");

        while (idx < n && (s.charAt(idx) == '{' || Character.isLetter(s.charAt(idx)))) {
            Set<String> temp = getUnit();
            Set<String> concatRes = new HashSet<>();

            for (String l : res) {
                for (String r : temp) {
                    concatRes.add(l + r);
                }
            }

            res = concatRes;
        }

        return res;
    }

    Set<String> performUnion() {
        Set<String> result = new HashSet<>();

        while (true) {
            Set<String> temp = concat();
            result.addAll(temp);

            if (idx < n && s.charAt(idx) == ',') {
                idx++;
            } else {
                break;
            }
        }

        return result;
    }

    public List<String> braceExpansionII(String expression) {
        n = expression.length();
        s = expression;
        idx = 0;

        Set<String> st = performUnion();

        List<String> ans = new ArrayList<>(st);
        Collections.sort(ans);

        return ans;
    }
}