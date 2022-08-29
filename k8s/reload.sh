BIN="drink"
TAG="3.0"

echo "===== Minikube check images"
minikube image ls | grep "$BIN"

echo "===== docker check images"
docker images | grep "$BIN"

echo "===== Kubectl delete pod... "
kubectl delete deploy $BIN
sleep 5

echo "===== Minikube reload image "
minikube image rm $BIN:$TAG
minikube image load $BIN:$TAG

echo "===== Kubectl re-deploy... "
kubectl apply -f $BIN.yml
kubectl get pods
