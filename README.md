# Testing repo reference formservice

* API
* Postman reference location - https://learning.postman.com/docs/getting-started/introduction/
* Newman for local installation  - https://www.npmjs.com/package/newman
* Newman execution local - https://www.npmjs.com/package/newman#using-newman-cli
* Newman CircleCI integration - https://circleci.com/blog/building-postman-test-reports/
   
* UI Tests
* GIT Fork - https://learning.postman.com/docs/collaborating-in-postman/version-control-for-collections/
* Geb reference - https://gebish.org/manual/current/#code-select-code
* Spock framework - https://spockframework.org/spock/docs/1.3/all_in_one.html

* Maveen Run config 
* VM OPtions please have this (Provide the browser, OS versions, local or remote)
* Shakeout   -DargLine="-Dlocal=false -Dbrowser=Safari -Dbrowser_version='14.0' -Dos='OS X' -Dos_version='Big Sur' -Dstage=shakeout -DcheckAccessibility=true"
* Regression  -DargLine="-Dlocal=false -Dbrowser=Safari -Dbrowser_version='14.0' -Dos='OS X' -Dos_version='Big Sur' -Dstage=regression -DcheckAccessibility=true"
* For Browserstack have local as false

* Performance testing 
* Run test -> jmeter -n -t FHEOSubmission.jmx -l testresults.jtl
* Generation of report -> jmeter -g testresults.jtl -o Reporttest
* Jmeter download -> https://www.apache.org/dist/jmeter/binaries/apache-jmeter-5.4.1.zip.sha512
* Advanced Thread Groups -> https://jmeter-plugins.org/?search=jpgc-casutg (jmeter-plugins-casutg-2.9.jar, jmeter-plugins-manager-1.3.jar, jmeter-plugins-cmn-jmeter-0.6.jar)
* Place the files in Jmeter\apache-jmeter-5.4.1\lib\ext
* Perfmon -> https://www.blazemeter.com/blog/how-monitor-your-server-health-performance-during-jmeter-load-test
