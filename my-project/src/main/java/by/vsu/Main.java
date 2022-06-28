package by.vsu;

import by.vsu.models.User;
import by.vsu.util.CryptoUtil;
import by.vsu.util.RepositoryProvider;

public class Main {
    
    public static void main(String[] args) throws Exception {
        for (User u : RepositoryProvider.getUserRepository().getAllUsers()) {
            System.out.println(u);
        }
        System.out.println(CryptoUtil.sha256("admin"));
    }
}
