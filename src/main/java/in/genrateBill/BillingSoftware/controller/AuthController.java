package in.genrateBill.BillingSoftware.controller;


import in.genrateBill.BillingSoftware.io.AuthRequest;
import in.genrateBill.BillingSoftware.io.AuthResponse;
import in.genrateBill.BillingSoftware.service.UserService;
import in.genrateBill.BillingSoftware.service.serviceimpl.AppUserDetailsService;
import in.genrateBill.BillingSoftware.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final AppUserDetailsService appUserDetailsService;

    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request)throws Exception{
        authenticate(request.getEmail(), request.getPassword());
        final UserDetails userDetails = appUserDetailsService.loadUserByUsername(request.getEmail());

        // after user get login we are genrating the token
          final String jwtToken=  jwtUtil.generateToken(userDetails);
           String role = userService.getUserRole(request.getEmail());
          return new AuthResponse(request.getEmail(), role,jwtToken);
    }

    private void authenticate(String email, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        }catch (DisabledException e){
            throw new Exception("User disabled");

        }catch (BadCredentialsException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email or password is incorrect");
        }

    }


    //encode the password becasuse
    //when application initially deploy production we need genrate the admin password
    @PostMapping("/encode")   //this endpoint help us to encode the password
        public String encoderPassword(@RequestBody Map<String , String> request){
                return passwordEncoder.encode(request.get("password"));
        }
}
