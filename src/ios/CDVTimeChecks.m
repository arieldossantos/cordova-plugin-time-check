#import "CDVTimeChecks.h"
#import <CoreLocation/CoreLocation.h>

@implementation CDVTimeChecks

- (void)isAutomaticTimeZone:(CDVInvokedUrlCommand*)command
{
    [self.commandDelegate runInBackground:^{
        CDVPluginResult* pluginResult = nil;
        if([NSTimeZone systemTimeZone] == [NSTimeZone defaultTimeZone]){
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }else{
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Timezone is not automatic"];
            [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
        }
    }];
}

@end
