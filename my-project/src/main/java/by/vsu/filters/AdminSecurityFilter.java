package by.vsu.filters;

public class AdminSecurityFilter extends RoleSecurityFilter {
    
    public AdminSecurityFilter() {
        super("admin");
    }
}