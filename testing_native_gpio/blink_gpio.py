import RPi.GPIO as GPIO
#GPIO.setmode(GPIO.BOARD)
GPIO.setmode(GPIO.BCM)
#GPIO.setup(12, GPIO.OUT)
GPIO.setup(5, GPIO.OUT)

#p = GPIO.PWM(12, 0.5)
p = GPIO.PWM(5, 0.5)
p.start(1)
input('Press return to stop:')   # use raw_input for Python 2
p.stop()
GPIO.cleanup()
