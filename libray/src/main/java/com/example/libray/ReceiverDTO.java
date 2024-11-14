package com.example.libray;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiverDTO {
    private String receiverDate;
    private String recoilDate;
    private String username;
    private String phoneNumber;
    private String bookName;
    private String author;
}
