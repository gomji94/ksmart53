package thymeleaf.exam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import thymeleaf.exam.dto.User;

@Service("examService")
public class ExamServiceImpl implements ExamService {

	@Override
	public User getUserInfo() {
		
		return new User("id001", "pw001", "홍01", "관리자", "홍01@ksmart.or.kr", "010-0001-0001");
	}

	@Override
	public List<User> getUserList() {
		
		List<User> userList = new ArrayList<User>();
		
		User userInfo = null;
		String[] grade = new String[] {"관리자","판매자","구매자"};
		for(int i=1; i<10; i++) {
			String userId = "id00" + i;
			String userPw = "pw" + String.format("%03d", i);
			String userName = "홍" + String.format("%02d", i);
			String userGrade = grade[(i-1) % grade.length];
			String userEmail = userName + "ksmart.or.kr";
			String userMobile = "010-" + String.format("%04d", i) + "-" + String.format("%04d", i);
			userInfo = new User();
			userInfo.setUserId(userId);
			userInfo.setUserPw(userPw);
			userInfo.setUserName(userName);
			userInfo.setUserGrade(userGrade);
			userInfo.setUserEmail(userEmail);
			userInfo.setUserMobile(userMobile);
			
			userList.add(userInfo);
		}
		return userList;
	}

}
