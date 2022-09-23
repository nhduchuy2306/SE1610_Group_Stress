
package com.stress.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userID;
    private String username;
    private String password;
    private String email;
    private Date dob;
    private String address;
    private String phoneNumber;
    private boolean sex;
    private String roleID;
    private float AccountBalance;
    private boolean status;
}
