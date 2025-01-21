class Solution {
	private String convertToValidEmail(String email) {
        String localName = email.substring(0, email.indexOf("@"));
        int indexOfPlus = localName.indexOf("+");
        if(indexOfPlus != -1) {
            localName = localName.substring(0, indexOfPlus);
        }
        localName = localName.replace(".","");
        
		String domainName = email.substring(email.indexOf("@") + 1);
        
		return localName + "@" + domainName ; 
	}

	public int numUniqueEmails(String[] emails) {
		Set<String> st = new HashSet<>();
		for(String email : emails) {
			st.add(convertToValidEmail(email));
		}
		return st.size();
	}
}