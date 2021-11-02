package plug

import (
    "log"

    "github.com/fsnotify/fsnotify"
)

// FileChange 判断文件是否变动 dir要监控的文件夹 bool
func FileChange(dir string) bool {
    watcher, err := fsnotify.NewWatcher()
    if err != nil {
        log.Fatal("NewWatcher failed: ", err)
    }
    defer watcher.Close()

    done := make(chan bool)
    go func() {
        defer close(done)

        for {
            select {
            case event, ok := <-watcher.Events:
                if !ok {
                    return
                }
                if event.Op == 1 || event.Op == 2 {
                    log.Printf("文件 [%s] 进行了 [%s] 操作\n", event.Name, event.Op)
                }
            case err, ok := <-watcher.Errors:
                if !ok {
                    return
                }
                log.Println("error:", err)
            }
        }
    }()

    err = watcher.Add(dir)
    if err != nil {
        log.Fatalf("监控目录[ %s ]失败,err %s", dir, err)
    }
    <-done

    return true
}
