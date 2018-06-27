# Spring_Micorservices_CORS

CORS - Cross-Origin Resource Sharing (CORS) is a W3C specification implemented by most browsers that allows you to 
specify what kind of cross domain requests are authorized rather than using less secure and less powerful workarounds.
List of permissible origins to access the API's can be added.

This Spring Boot project explains how to Configure the Global CORS in a Micro-services architecture

There are two ways to achieve this -

1)  Configure via Application properties/yaml file -- Limitations is Runtime changes can't be done.
2)  Spring cloud configuration properties via Bootstrap file and Runtime properties changes can be done without buildind
	& redeploying the application.
	
By default global configuration enables the following values:

Allowed-Origins - All origins.
Allowed-Headers - All headers.
Allowed-Methods - GET, HEAD, and POST methods.
Allowed-Credentials - is not enabled by default since that establishes a trust level 
					  that exposes sensitive user-specific information such as cookies and CSRF tokens,
					  and should only be used where appropriate.

maxAge is set to 30 minutes.

This example illustrates how to configure via application properties/yml file.
