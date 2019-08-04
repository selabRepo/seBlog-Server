package com.se.seblog.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.se.seblog.user.service.CustomUserDetailsService;

/**
 * jwt 인증 필터 
 * 
 * @author youngjun.jin
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	/**  토큰 제공 인스턴스 */
	@Autowired
    private JwtTokenProvider tokenProvider;
	
	/**  토큰 검증 인스턴스 */
	@Autowired
	private JwtTokenValidator tokenValidator;
	
    /**  userDetailsService */
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && this.tokenValidator.validateToken(jwt)) {
                Long userId = tokenProvider.getUserIdFromJwt(jwt);

                UserDetails userDetails = customUserDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
		
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		
        String bearerToken = request.getHeader("Authorization");
        
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

}
