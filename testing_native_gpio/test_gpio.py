import RPi.GPIO as GPIO
#help(GPIO)
#GPIO.setmode(GPIO.BOARD)
GPIO.setmode(GPIO.BCM)
GPIO.setup(5, GPIO.OUT)
for j in range(100000):
    for i in range(100000):
        GPIO.output(5, True)
        print 'led on', i, j
    for i in range(100000):
        GPIO.output(5, False)
        print 'led off', i, j
        

