
# Bug Report

## BUG-001

**Title:**
Logout action does not redirect to the login page consistently

**Module:**
Logout

**Environment:**
Windows 11
Google Chrome
SauceDemo

**Severity:**
Medium

**Priority:**
High

**Status:**
Fixed

### Steps to Reproduce

1. Open the SauceDemo website
2. Login with valid credentials
3. Open the side menu
4. Click Logout
5. Observe the resulting page

### Expected Result

The user should be logged out and redirected to the login page.

### Actual Result

During automation testing the logout action did not consistently complete before the verification step. The browser sometimes remained on the inventory page.

### Resolution

Added explicit waits for the menu and logout elements and waited for the expected URL before performing the final assertion.

### Test Case

TC_LOGOUT_001
