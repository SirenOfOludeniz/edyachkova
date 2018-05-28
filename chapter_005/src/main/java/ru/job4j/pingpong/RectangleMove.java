package ru.job4j.pingpong;
import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable{
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            if (this.rect.getX() != 0 && this.rect.getX() != 300) {
                this.rect.setX(this.rect.getX() + 1);
            }
            if (this.rect.getY() != 0 && this.rect.getY() != 300) {
                this.rect.setY(this.rect.getY() + 1);
            }
           // this.rect.setX(this.rect.getX() + 1);
            borderMove();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           /* if (current.isInterrupted()) {
                return;
            }*/
        }
    }

    /*public void run() {
        while (true) {
            if (this.rect.getX() != 0 && this.rect.getX() != 300) {
                this.rect.setX(this.rect.getX() + 1);
            }
            if (this.rect.getY() != 0 && this.rect.getY() != 300) {
                this.rect.setY(this.rect.getY() + 1);
            }
           if (this.rect.getX() == 0 && this.rect.getX() == 300) {
                detectBorder(this.rect.getX(), this.rect.getY());
                while (this.rect.getY() < 300 && this.rect.getY() > 0) {
                    randomMoveY((int)(Math.random() * 10));
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           } else if (this.rect.getY() == 0 && this.rect.getY() == 300) {
                detectBorder(this.rect.getY(), this.rect.getX());
               while (this.rect.getX() < 300 && this.rect.getX() > 0) {
                   randomMoveX((int)(Math.random() * 10));
                   try {
                       Thread.sleep(30);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }*/



    public void detectBorder(double coordinate, double randomCoord) {
        if (coordinate == 0 ) {
            int random = (int)(Math.random() * 10);
            while (coordinate < 300 && randomCoord < 300 && randomCoord > 0) {
                coordinate += 1;
               // randomMoveCoordinate(random, randomCoord);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if (coordinate == 300) {
            int random = (int)(Math.random() * 10);
            while (coordinate > 0 && randomCoord < 300 && randomCoord > 0) {
                coordinate -= 1;
               // randomMoveCoordinate(random, randomCoord);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void borderMove() {
        if (this.rect.getY() <= 0) {
            int random = (int)(Math.random() * 10);
            while (this.rect.getY() < 300 && this.rect.getX() < 300 && this.rect.getX() > 0) {
                this.rect.setY(this.rect.getY() + 1);
                randomMoveX(random);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if (this.rect.getY() >= 300) {
            int random = (int)(Math.random() * 10);
            while (this.rect.getY() > 0 && this.rect.getX() < 300 && this.rect.getX() > 0) {
                this.rect.setY(this.rect.getY() - 1);
                randomMoveX(random);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (this.rect.getX() <= 0) {
            int random = (int)(Math.random() * 10);
            while (this.rect.getX() < 300 && this.rect.getY() < 300 && this.rect.getY() > 0) {
                this.rect.setX(this.rect.getX() + 1);
                randomMoveY(random);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        if (this.rect.getX() >= 300) {
            int random = (int)(Math.random() * 10);
            while (this.rect.getX() > 0 && this.rect.getY() < 300 && this.rect.getY() > 0) {
                this.rect.setX(this.rect.getX() - 1);
                randomMoveY(random);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void randomMoveX(int a) {
        if (a >= 0 && a <= 4) {
            this.rect.setX(this.rect.getX() - 1);
        } else if (a > 4 && a <= 8) {
            this.rect.setX(this.rect.getX() + 1);
        } else if (a > 8 && a <= 10) {
            this.rect.setX(this.rect.getX() + 0);
        }
    }
    public void randomMoveY(int a) {
        if (a >= 0 && a <= 4) {
            this.rect.setY(this.rect.getY() - 1);
        } else if (a > 4 && a <= 8) {
            this.rect.setY(this.rect.getY() + 1);
        } else if (a > 8 && a <= 10) {
            this.rect.setY(this.rect.getY() + 0);
        }
    }
    public void randomMoveCoordinate(int a, double coord) {
        if (a >= 0 && a <= 4) {
            coord -= 1;
        } else if (a > 4 && a <= 8) {
            coord += 1;
        } else if (a > 8 && a <= 10) {
            coord += 0;
        }
    }
}
