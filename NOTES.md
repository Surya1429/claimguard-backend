# Spring Security Learning Notes

## Day 1
- Adding spring-boot-starter-security locks all URLs by default.
- Spring creates a default user "user" with a generated password.
- Every request goes through the Security Filter Chain (~15 filters) before the controller.
- 401 = not authenticated (who are you?)

## Day 2
- My own SecurityFilterChain bean replaces Spring's default rules.
- permitAll() = public, authenticated() = login required. Rules are checked top to bottom.
- UserDetailsService = where Spring finds users (in-memory today, DB later).
- Defining my own UserDetailsService removes the generated default user.
- roles("X") is stored as authority "ROLE_X".
- {noop} = plain-text password, only for learning.
- Config decides which filters are in the chain (no formLogin → no login page filters).