package by.vsu.filters;

public class UserSecurityFilter extends RoleSecurityFilter {
    
    public UserSecurityFilter() {
        super("user");
    }
}