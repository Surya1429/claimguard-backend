# Spring Security Learning Notes

## Day 1
- Adding spring-boot-starter-security locks all URLs by default.
- Spring creates a default user "user" with a generated password.
- Every request goes through the Security Filter Chain (~15 filters) before the controller.
- 401 = not authenticated (who are you?)