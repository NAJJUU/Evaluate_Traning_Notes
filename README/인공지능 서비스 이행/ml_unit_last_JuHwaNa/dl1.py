import numpy as np
import matplotlib.pyplot as plt

def step(x):
    result = x > 0.00000001      # 부동소수점 오차 방지
    result = result.astype(int)  # 정수로 변환
    result = result * 2 - 1     # 값을 -1과 1로 매핑
    return result

plt.figure(figsize=(15, 3))
x = np.arange(-6.0, 6.0, 0.00001)
y = step(x)
plt.subplot(1, 4, 1)
plt.plot(x, y)
plt.grid()
# plt.yticks(np.arange(-1, 1.5, 0.5))
plt.title('step')


def sigmoid(x):
    return 1.0/(1.0 + np.exp(-x))

x = np.arange(-6.0, 6.0, 0.00001)
y = sigmoid(x)
plt.subplot(1, 4, 2)
plt.plot(x, y)
plt.grid()
plt.title('logistic sigmoid')


# 지정된 구간 내에서 균열한 간격으로 수를 가지는 배열을 반환함
x = np.linspace(-6.0, 6.0, 60)
y = np.tanh(x)
plt.subplot(1, 4, 3)
plt.plot(x, y)
# plt.yticks(np.arange(-1, 1.5, 0.5))
plt.grid()
plt.title('tanh(hyperbolic tangent)')


def relu(x):
    return np.maximum(x, 0)

def softplus(x):
    return np.log(1 + np.exp(x))

x = np.arange(-6.0, 6.0, 0.00001)
y_relu = relu(x)
y_softplus = softplus(x)
plt.subplot(1, 4, 4)
plt.plot(x, y_relu, label='ReLU')
plt.plot(x, y_softplus, label='Softplus')
plt.grid()
plt.title('ReLU and Softplus')
plt.legend()

plt.tight_layout()  # 그래프 간격 조정

plt.show()