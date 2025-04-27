package in.genrateBill.BillingSoftware.service;

import in.genrateBill.BillingSoftware.io.UserRequest;
import in.genrateBill.BillingSoftware.io.UserResponse;

import java.util.List;


public interface UserService {

    UserResponse createUser(UserRequest request);

    String  getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
