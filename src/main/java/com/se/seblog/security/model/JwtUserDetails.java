package com.se.seblog.security.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.se.seblog.user.model.entity.UserDto;

/**
 * jwtUserDetails
 * 
 * @author youngjun.jin
 */
public class JwtUserDetails implements UserDetails {

	/** serial id */
	private static final long serialVersionUID = 758700484936510374L;

	/** user id */
	private Long id;

	/** 사용자 이름 */
	private String name;

	/** user login id */
	@JsonIgnore
	private String userName;

	/** password */
	@JsonIgnore
	private String password;

	/** authorities */
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails(Long id, String name, String userName, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
	}

	/**
	 * userDto 를 통해 JwtUserDetails 인스턴스를 생성합니다.
	 * 
	 * @param userDto userDto
	 * @return jwtUserDetails
	 */
	public static JwtUserDetails create(UserDto userDto) {
		List<GrantedAuthority> authorities = userDto.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());

		return new JwtUserDetails(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return this.id;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public String getName() {
		return this.name;
	}

}
